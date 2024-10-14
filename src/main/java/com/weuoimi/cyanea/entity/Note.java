package com.weuoimi.cyanea.entity;

import com.weuoimi.cyanea.factory.NoteType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "notes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note implements Noteable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "file_path")
    private String filePath;

    // TODO: is it ok?
    @Enumerated
    @Column(name = "note_type")
    private NoteType noteType;

    // TODO: is it ok to store the contents in relational db?
    @Column(name = "contents")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;
}
