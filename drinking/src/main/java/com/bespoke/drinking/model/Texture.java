package com.bespoke.drinking.model;

public enum Texture {
	LIQUID("Liquid"),
	HALF_THICC("Half thicc"),
	THICC("Thicc");
	
	String texture;
	
	private Texture(String texture) { this.texture = texture; }
	
	@Override
	public String toString() {
		return this.texture;
	}
	
	public static Texture fromString(String text) {
        for (Texture t : Texture.values()) {
            if (t.toString().equalsIgnoreCase(text)) {
                return t;
            }
        }
        return null;
	}
}
