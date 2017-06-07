package gettingstarted;

import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.commons.repository.Store;

import internal.org.springframework.content.rest.annotations.ContentStoreRestResource;

@ContentStoreRestResource(path="/files")
public interface FileContentStore extends Store<String>, ContentStore<File, String> {
}
