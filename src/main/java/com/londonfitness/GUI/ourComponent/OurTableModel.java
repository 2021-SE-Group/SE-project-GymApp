package com.londonfitness.GUI.ourComponent;

import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public abstract class OurTableModel<T> implements TableModel {
    protected EventListenerList listenerList = new EventListenerList();
    private ArrayList<T> list;
    private int columnCount;

    public OurTableModel(ArrayList<T> list, int columnC) {
        this.list = list;
        this.columnCount = columnC;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    /*
    @Override
    public String getColumnName(int columnIndex) {
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
     */

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getValueAtColumn(list.get(rowIndex), columnIndex) ;
    }

    public abstract Object getValueAtColumn(T t, int columnIndex);

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        setValueAtColumn(aValue, list.get(rowIndex), columnIndex);
    }

    public abstract void setValueAtColumn(Object aValue, T t, int columnIndex);

    @Override
    public void addTableModelListener(TableModelListener l) {
        this.listenerList.add(TableModelListener.class, l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listenerList.remove(TableModelListener.class, l);
    }
}
