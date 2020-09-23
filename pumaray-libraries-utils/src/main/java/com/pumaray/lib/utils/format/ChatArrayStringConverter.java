package com.pumaray.lib.utils.format;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class ChatArrayStringConverter extends Format {

	@Override
	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
		char[] charArray = (char[]) obj;
		if (charArray == null || charArray.length == 0) {
			charArray = "".toCharArray();
		}
		toAppendTo.append(new String(charArray));
		return toAppendTo;
	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		return parseObject(source);
	}

	@Override
	public char[] parseObject(String source) {
		return source.toCharArray();
	}

}
