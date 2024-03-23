package jh.naverwebtoon.db.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MergeManuscript {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private UploadImage file;

    public static MergeManuscript create(UploadImage file) {
        MergeManuscript mergeManuscript = new MergeManuscript();
        mergeManuscript.file = file;
        return mergeManuscript;
    }
}