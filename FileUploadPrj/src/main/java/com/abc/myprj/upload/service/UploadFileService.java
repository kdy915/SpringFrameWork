package com.abc.myprj.upload.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.myprj.upload.dao.IUploadFileRepository;
import com.abc.myprj.upload.model.UploadFileVO;

@Service
public class UploadFileService implements IUploadFileService {
	
	@Autowired
	IUploadFileRepository uploadFileRepository;
	
	@Override
	public void uploadFile(UploadFileVO file) {
		file.setFileId(uploadFileRepository.getMaxFileId()+1);
		uploadFileRepository.uploadFile(file);
	}

	@Override
	public List<UploadFileVO> getFileList(String directoryName) {
		return uploadFileRepository.getFileList(directoryName);
	}

	@Override
	public List<UploadFileVO> getAllFileList() {
		return uploadFileRepository.getAllFileList();
	}

	@Override
	public List<UploadFileVO> getImageList(String directoryName) {
		return uploadFileRepository.getImageList(directoryName);
	}

	@Override
	public UploadFileVO getFile(int fileId) {
		return uploadFileRepository.getFile(fileId);
	}

	@Override
	public String getDirectoryName(int fileId) {
		return uploadFileRepository.getDirectoryName(fileId);
	}

	@Override
	public void updateDirectory(int[] fileIds, String directoryName) {
		for(int fileId : fileIds) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("fileId", fileId);
			map.put("directoryName", directoryName);
			uploadFileRepository.updateDirectory(map);
		}
	}

	@Override
	public void delteFile(int fileId) {
		uploadFileRepository.delteFile(fileId);
	}

	@Override
	public void updateFile(UploadFileVO file) {
		uploadFileRepository.updateFile(file);
	}

}
