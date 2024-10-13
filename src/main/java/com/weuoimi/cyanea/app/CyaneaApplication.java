package com.weuoimi.cyanea.app;

import com.weuoimi.cyanea.NoteBuilderParams;
import com.weuoimi.cyanea.Noteable;
import com.weuoimi.cyanea.factory.NoteType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Optional;

@SpringBootApplication
public class CyaneaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyaneaApplication.class, args);

		// EXAMPLE USAGE OF FACTORY
		var exampleNoteParams = NoteBuilderParams.builder()
				.title(() -> "example") // logic of getting the title, not necessarily specified
				.filePath(() -> new File("/path/to/file")) // required!
				.group(Optional::empty) // the logic of getting the group, not necessarily specified, can be empty
				.build();

		// ! Instead of getNoteType there should be pattern matcher which will find out which the type
		// the file belongs to!
		// f.e. typeFinder(exampleNoteParams.getFilePath()).getNotetype().create(exampleNoteParams)
		Noteable note = exampleNoteParams.getNoteType().create(exampleNoteParams);
	}
}
