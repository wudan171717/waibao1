package entity;

import java.io.Serializable;

public class Community implements Serializable{
	private int id;
	private String name;
	private String time;
	private String address;
	private String img;
	private String content;
	private String writer;
	private String imgs;
	
	public Community() {
		super();
	}

	public Community(int id, String name, String time, String address,
			String img, String content, String writer, String imgs) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.address = address;
		this.img = img;
		this.content = content;
		this.writer = writer;
		this.imgs = imgs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String toString() {
		return "Community [id=" + id + ", name=" + name + ", time=" + time
				+ ", address=" + address + ", img=" + img + ", content="
				+ content + ", writer=" + writer + ", imgs=" + imgs + "]";
	}
	
	
	
}
