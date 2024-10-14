package com.weuoimi.cyanea.parsers;

import java.io.File;

public interface Parser {
    String parseTitle(File file);
    String parseContents(File file);
}
