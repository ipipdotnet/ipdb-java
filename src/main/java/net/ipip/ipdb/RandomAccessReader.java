package net.ipip.ipdb;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSONObject;

import sun.misc.Unsafe;

/**
 * @author mckuhei
 * */
public class RandomAccessReader extends Reader implements Closeable {
	
	private static final Unsafe U = getUnsafe();
	private RandomAccessFile handle;
	private long baseOffset;

	public RandomAccessReader(String file) throws IOException, InvalidDatabaseException {
		this(new File(file));
	}

	public RandomAccessReader(File file) throws IOException, InvalidDatabaseException {
		try {
			this.fileSize = (int) file.length();
			RandomAccessFile handle = this.handle = new RandomAccessFile(file, "r");
			int metaLength = handle.readInt();
			byte[] metaBytes = new byte[metaLength];
			handle.readFully(metaBytes);
			
			String metaString = new String(metaBytes);
			
			MetaData meta = JSONObject.parseObject(metaString, MetaData.class);
            this.nodeCount = meta.nodeCount;
            this.meta = meta;
            
            this.baseOffset = handle.getFilePointer();
            
            /** for ipv4 */
            if (0x01 == (this.meta.IPVersion & 0x01))
            {
                int node = 0;
                for (int i = 0; i < 96 && node < this.nodeCount; i++) {
                    if (i >= 80) {
                        node = this.readNode(node, 1);
                    } else {
                        node = this.readNode(node, 0);
                    }
                }

                this.v4offset = node;
            }
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw new InvalidDatabaseException(e);
		}
	}
	
	@Override
    int readNode(int node, int index) {
        int off = node * 8 + index * 4;
        RandomAccessFile handle = this.handle;
        try {
			synchronized (handle) {
				handle.seek(this.baseOffset + off);
				return handle.readInt();
			}
		} catch (IOException e) {
			U.throwException(e);
		}
        throw new InternalError("Should not reach here");
    }
	
	@Override
	String resolve(int node) throws InvalidDatabaseException {
        final int resoloved = node - this.nodeCount + this.nodeCount * 8;
        if (resoloved >= this.fileSize) {
            throw new InvalidDatabaseException("database resolve error");
        }
        
        RandomAccessFile handle = this.handle;
        
        try {
        	byte[] data;
        	synchronized (handle) {
        		handle.seek(this.baseOffset + resoloved);
            	int size = handle.readUnsignedShort();

                if (this.fileSize < (resoloved + 2 + size)) {
                    throw new InvalidDatabaseException("database resolve error");
                }

                data = new byte[size];
                handle.readFully(data);
        	}
            return new String(data, StandardCharsets.UTF_8);
		} catch (IOException e) {
			U.throwException(e);
		}
        throw new InternalError("Should not reach here");
    }

	private static Unsafe getUnsafe() {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			return (Unsafe) f.get(null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new InternalError("Unable to get unsafe", e);
		}
	}
	
	@Override
	protected void finalize() {
		close();
	}

	public void close() {
		try {
			this.handle.close();
		} catch (IOException e) {
			U.throwException(e);
		}
	}
}
