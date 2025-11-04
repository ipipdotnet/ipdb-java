package net.ipip.ipdb;

public class IPFormatException extends Exception {

    public IPFormatException(String name) {
        super(name);
    }

	public IPFormatException(Throwable cause) {
		super(cause);
	}
}
