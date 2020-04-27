package com.ara.elastic;

import com.ara.elastic.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SavePostTest {

    @Test
    void shouldCreateNewPost() {
        Post post = new Post();
        post.setAuthor("Radek");
        post.setContent("While Elasticsearch is schemaless, it can use mappings in order to tell the type of a field. When a document is indexed, its fields are processed according to their types. For example, a text field will be tokenized and filtered according to mapping rules. You could also create filters and tokenizers of your own.");
        post.setTitle("");
    }

}
