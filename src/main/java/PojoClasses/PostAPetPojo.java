package PojoClasses;

import java.util.*;



public class PostAPetPojo {

	private long id;
	private Map<String, Object> category;
	private String name;
	private List<String> photoUrls;
	private List<Map<String, Object>> tags;
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Map<String, Object> getCategory() {
		return category;
	}

	public void setCategory(Map<String, Object> category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public List<Map<String, Object>> getTags() {
		return tags;
	}

	public void setTags(List<Map<String, Object>> tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}