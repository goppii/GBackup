package com.gbackup.components;

import java.util.Vector;

public class PathControllerC {
    
    private Vector<String> m_pathVector = null;
    
    public PathControllerC()
    {
        m_pathVector = new Vector<>();
    }
    
    public void addPath(String path)
    {
        if(!isDuplicate(path))
        {
            m_pathVector.add(path);
        }
    }
    
    public boolean removePath(String path)
    {
        for (String pathObject : m_pathVector)
        {
            if(pathObject.equals(path))
            {
                m_pathVector.remove(pathObject);
                return true;
            }
        }

        return false;
    }

    public Vector<String> getPaths()
    {
        return m_pathVector;
    }
    
    private boolean isDuplicate(String path)
    {
        for (String pathObject : m_pathVector)
        {
            if(pathObject.equals(path))
            {
                return true;
            }
        }

        return false;
    }
}
