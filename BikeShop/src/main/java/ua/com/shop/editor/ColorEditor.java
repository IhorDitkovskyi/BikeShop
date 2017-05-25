package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;

public class ColorEditor extends PropertyEditorSupport{

	private ColorService colorService;

	public ColorEditor(ColorService colorService) {
		this.colorService = colorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Color color = colorService.findOne(Integer.valueOf(text));
		setValue(color);
	}
	
}
