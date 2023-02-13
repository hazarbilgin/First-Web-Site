package com.Proje.fullstack.Request;

import lombok.Data;

@Data
public class PostUpdateRequest {
String Title;
String Text;
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getText() {
	return Text;
}
public void setText(String text) {
	Text = text;
}

}
