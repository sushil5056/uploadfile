package com.uploadfile.demo.repo;

import com.uploadfile.demo.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileData,Integer> {
}
