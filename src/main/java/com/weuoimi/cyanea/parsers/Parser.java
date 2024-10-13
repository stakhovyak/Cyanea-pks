package com.weuoimi.cyanea.parsers;

import com.weuoimi.cyanea.Noteable;

import java.io.File;

public interface Parser {
    Noteable parse(File file);
}
