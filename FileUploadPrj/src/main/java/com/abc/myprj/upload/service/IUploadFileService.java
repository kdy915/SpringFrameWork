package com.abc.myprj.upload.service;

import java.util.List;

import com.abc.myprj.upload.model.UploadFileVO;

public interface IUploadFileService {
	void uploadFile(UploadFileVO file);
	
	List<UploadFileVO> getFileList(String directoryName);
	List<UploadFileVO> getAllFileList();
	List<UploadFileVO> getImageList(String directoryName);
	
	UploadFileVO getFile(int fileId);
	
	String getDirectoryName(int fileId);
	void updateDirectory(int[] fileIds, String directoryName);
	
	void delteFile(int fileId);
	void updateFile(UploadFileVO file);
}
