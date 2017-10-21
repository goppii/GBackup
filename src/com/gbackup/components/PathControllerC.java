package com.gbackup.components;

import java.util.*;

public class PathControllerC extends SubjectC{
    
    private Vector<String> m_pathVector = null;
    private Map<String,PathC> m_pathMap = null;
    
    public PathControllerC()
    {
        m_pathVector = new Vector<>();
        m_pathMap = new HashMap<>();
    }
    
    public void addPath(String path)
    {
        if(!m_pathMap.containsKey(path))
        //if(!isDuplicate(path))
        {
            //m_pathVector.add(path);
            m_pathMap.put(path, new PathC(path));
            notify(this.getClass().getName(), PathControllerTypesC.PathEventType.ADD.getValue());
        }
    }
    
    public boolean removePath(String path)
    {
        if(m_pathMap.containsKey(path))
        {
            m_pathMap.remove(path);
            return true;
        }

        return false;
/*        for (String pathObject : m_pathVector)
        {
            if(pathObject.equals(path))
            {
                m_pathVector.remove(pathObject);
                notify(PathControllerTypesC.PathEventType.REMOVE.getValue(), 0);
                return true;
            }
        }

        return false;*/
    }

    public Vector<String> getPaths()
    {
        Vector<String> pathVector = new Vector<>();

        for (String key : m_pathMap.keySet())
        {
            pathVector.add(key);
        }

        return pathVector;
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
