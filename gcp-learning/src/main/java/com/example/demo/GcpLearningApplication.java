package com.example.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.StorageOptions;

@SpringBootApplication
public class GcpLearningApplication implements CommandLineRunner {
	@Autowired
	Environment environment;
	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(GcpLearningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String gev_path = environment.getProperty("GOOGLE_APPLICATION_CREDENTIALS");
		System.out.println(gev_path);
		InputStream inputStream = new FileInputStream(gev_path);

		Person p = new Person("1", "Anurag", "34");
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(p);
		System.out.println(writeValueAsString);
		com.google.cloud.storage.Storage storage = StorageOptions.newBuilder().setProjectId("my-first-gcp-practical")
				.build().getService();
		
		Blob blob = storage.get("anurag-gcp-bucket-1","sample1.txt");
		//Blob blob = storage.get(BUCKET_URL, OBJECT_URL);
		String fileContent = new String(blob.getContent());
		//ReadChannel r = blob.reader();
		
		System.out.println(fileContent);
		
		  BlobId blobId = BlobId.of("anurag-gcp-bucket-1", "sample1.txt"); BlobInfo
		  blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
		  // storage. // storage.create(blobInfo,
		  Files.readAllBytes(Paths.get("sample1.txt")));
		  
		  try (WriteChannel writer = storage.writer(blobInfo)) { byte[] bytes =
		  writeValueAsString.getBytes(); writer.write(ByteBuffer.wrap(bytes, 0,
		  bytes.length)); }
		 

		
		  StorageClass storageClass = StorageClass.COLDLINE; Bucket bucket =
		  storage.create( BucketInfo.newBuilder("anurag-gcp-bucket-1")
		  .setStorageClass(storageClass) // .setLocation(location) .build());
		  System.out.println( "Created bucket " + bucket.getName() + " in " +
		  bucket.getLocation() + " with storage class " + bucket.getStorageClass());
		 
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
