package com.gbackup.components;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathC {

    private String m_path;

    public PathC(String path)
    {
        m_path = path;
    }

    public long getSize()
    {
        Path folder = Paths.get(m_path);
        long size = 0;
        try
        {
            size = Files.walk(folder).filter(p -> p.toFile().isFile()).mapToLong(p -> p.toFile().length()).sum();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return size;
    }
}
