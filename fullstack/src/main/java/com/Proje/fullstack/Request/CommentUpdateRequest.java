package com.Proje.fullstack.Request;

import lombok.Data;

@Data
public class CommentUpdateRequest {
String Text;

public String getText() {
	return Text;
}

public void setText(String text) {
	Text = text;
}


}
