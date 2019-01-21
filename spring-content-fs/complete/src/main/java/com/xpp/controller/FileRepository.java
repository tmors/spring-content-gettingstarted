package com.xpp.controller;

import com.xpp.entity.FileMapperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="files", collectionResourceRel="sc_file_mapper")
public interface FileRepository extends JpaRepository<FileMapperEntity, Long> {

}
