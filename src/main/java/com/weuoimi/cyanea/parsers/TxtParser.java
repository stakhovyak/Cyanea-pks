package com.weuoimi.cyanea.parsers;

import com.weuoimi.cyanea.Noteable;
import com.weuoimi.cyanea.entity.Note;

import java.io.File;

public class TxtParser implements Parser {
    @Override
    public Noteable parse(File file) {
        // TODO: placeholder method!
        return new Note();
    }
}
