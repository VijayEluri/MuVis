/*
* The GPLv3 licence :
* -----------------
* Copyright (c) 2009 Ricardo Dias
*
* This file is part of MuVis.
*
* MuVis is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* MuVis is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with MuVis.  If not, see <http://www.gnu.org/licenses/>.
*/

package muvis.view.table;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import muvis.Messages;

/**
 *
 * @author Ricardo
 */
public class JTableMouseAdapter extends MouseAdapter {

    private int lastSelectedRow = 0;

    private void maybeShowPopup(MouseEvent e) {

        JTable tracksTable = (JTable)e.getSource();

        if (e.isPopupTrigger() && tracksTable.isEnabled()) {
            Point p = new Point(e.getX(), e.getY());
            int col = tracksTable.columnAtPoint(p);
            int row = tracksTable.rowAtPoint(p);

            lastSelectedRow = row;

            // translate table index to model index
            int mcol = tracksTable.getColumn(
                    tracksTable.getColumnName(col)).getModelIndex();

            if (row >= 0 && row < tracksTable.getRowCount()) {

                // create popup menu...
                JPopupMenu contextMenu = createContextMenu(tracksTable, mcol);

                // Get the ListSelectionModel of the JTable
                if (tracksTable.getSelectedRowCount() <= 1) {
                    ListSelectionModel model = tracksTable.getSelectionModel();

                    // set the selected interval of rows. Using the "rowNumber"
                    // variable for the beginning and end selects only that one row.
                    model.setSelectionInterval(row, row);
                }

                // ... and show it
                if (contextMenu != null && contextMenu.getComponentCount() > 0) {
                    contextMenu.show(tracksTable, p.x, p.y);
                }
            }
        }
    }

    private JPopupMenu createContextMenu(JTable tracksTable, int columnIndex) {

        //creating the JPopupMenu and the menu items
        JPopupMenu contextMenu = new JPopupMenu();
        JMenuItem previewElementMenu = new JMenuItem();
        JMenuItem findSimilarElementMenu = new JMenuItem();
        JMenuItem findNonSimilarElementMenu = new JMenuItem();
        JMenuItem addElementToPlaylistMenu = new JMenuItem();
        JMenuItem closeMenu = new JMenuItem();

        //setting the labels for the menu items
        String colName = tracksTable.getModel().getColumnName(columnIndex);
        if (colName.equals(Messages.COL_TRACK_NAME_LABEL)) {
            findSimilarElementMenu.setText(Messages.FIND_SIMILAR_TRACKS_LABEL);
            findNonSimilarElementMenu.setText(Messages.FIND_NON_SIMILAR_TRACKS_LABEL);

            if (tracksTable.getSelectedRowCount() <= 1) {
                previewElementMenu.setText(Messages.PREVIEW_TRACK_LABEL);
                addElementToPlaylistMenu.setText(Messages.ADD_TRACK_PLAYLIST_LABEL);
            } else {
                previewElementMenu.setText(Messages.PREVIEW_SEVERAL_TRACKS_LABEL);
                addElementToPlaylistMenu.setText(Messages.ADD_SEVERAL_TRACKS_PLAYLIST_LABEL);
            }
        } else if (colName.equals(Messages.COL_ALBUM_NAME_LABE)) {
            findSimilarElementMenu.setText(Messages.FIND_SIMILAR_ALBUMS_LABEL);
            findNonSimilarElementMenu.setText(Messages.FIND_NON_SIMILAR_ALBUMS_LABEL);

            if (tracksTable.getSelectedRowCount() <= 1) {
                previewElementMenu.setText(Messages.PREVIEW_ALBUM_LABEL);
                addElementToPlaylistMenu.setText(Messages.ADD_ALBUM_PLAYLIST_LABEL);
            } else {
                previewElementMenu.setText(Messages.PREVIEW_SEVERAL_ALBUMS_LABEL);
                addElementToPlaylistMenu.setText(Messages.ADD_SEVERAL_ALBUMS_PLAYLIST_LABEL);
            }
        } else if (colName.equals(Messages.COL_ARTIST_NAME_LABEL)) {
            findSimilarElementMenu.setText(Messages.FIND_SIMILAR_ARTISTS_LABEL);
            findNonSimilarElementMenu.setText(Messages.FIND_NON_SIMILAR_ARTISTS_LABEL);

            if (tracksTable.getSelectedRowCount() <= 1) {
                previewElementMenu.setText(Messages.PREVIEW_ARTIST_LABEL);
                addElementToPlaylistMenu.setText(Messages.ADD_ARTIST_PLAYLIST_LABEL);
            } else {
                previewElementMenu.setText(Messages.PREVIEW_SEVERAL_ARTISTS_LABEL);
                addElementToPlaylistMenu.setText(Messages.ADD_SEVERAL_ARTISTS_PLAYLIST_LABEL);
            }
        } else {
            return contextMenu;
        }

        closeMenu.setText(Messages.CLOSE_LABEL);

        findNonSimilarElementMenu.addActionListener(new FindNonSimilarElementsAction(tracksTable));
        findSimilarElementMenu.addActionListener(new FindSimilarElementsAction(tracksTable));

        /*
        addElementToPlaylistMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem item = (JMenuItem) e.getSource();

                    if (item.getText().contains("Track")) {
                        //add a track to playlist
                        threadPool.execute(new Runnable() {

                            @Override
                            public void run() {
                                //add album to playlist
                                int[] rows = tracksTableView.getSelectedRows();
                                for (int i = 0; i < rows.length; i++) {
                                    int rowModel = tracksTableView.getRowSorter().convertRowIndexToModel(rows[i]);
                                    int id = (Integer) model.getValueAt(rowModel, 0);
                                    controller.addTrackToPlaylist(id, parent);
                                }
                            }
                        });

                    } else if (item.getText().contains("Album")) {
                        threadPool.execute(new Runnable() {

                            @Override
                            public void run() {
                                //add album to playlist
                                int[] rows = tracksTableView.getSelectedRows();
                                for (int i = 0; i < rows.length; i++) {
                                    int rowModel = tracksTableView.getRowSorter().convertRowIndexToModel(rows[i]);
                                    int id = (Integer) model.getValueAt(rowModel, 0);
                                    controller.addAlbumToPlaylist(id, parent);
                                }
                            }
                        });

                    } else if (item.getText().contains("Artist")) {
                        threadPool.execute(new Runnable() {

                            @Override
                            public void run() {
                                //add artist to playlist
                                int[] rows = tracksTableView.getSelectedRows();
                                for (int i = 0; i < rows.length; i++) {
                                    int rowModel = tracksTableView.getRowSorter().convertRowIndexToModel(rows[i]);
                                    int id = (Integer) model.getValueAt(rowModel, 0);
                                    controller.addArtistToPlaylist(id, parent);
                                }
                            }
                        });
                    }
                }
            }
        });

        previewElementMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JMenuItem) {
                    JMenuItem item = (JMenuItem) e.getSource();

                    if (item.getText().contains("Preview Track")) {
                        //preview of a track
                        if (tracksTable.getSelectedRowCount() <= 1) {
                            int row = tracksTable.getRowSorter().convertRowIndexToModel(lastSelectedRow);
                            int trackId = (Integer) model.getValueAt(row, 0);
                            Environment.getWorkspaceInstance().getSnippetManager().previewTrack(trackId);
                        } else {
                            ArrayList<Integer> trackIds = new ArrayList<Integer>(tracksTable.getSelectedRowCount());
                            for (int row : tracksTable.getSelectedRows()) {
                                int rowModel = tracksTable.getRowSorter().convertRowIndexToModel(row);
                                int id = (Integer) model.getValueAt(rowModel, 0);
                                trackIds.add(id);
                            }
                            Environment.getWorkspaceInstance().getSnippetManager().previewTracks(trackIds);
                        }

                    } else if (item.getText().contains("Album")) {
                        //preview of an album
                        if (tracksTable.getSelectedRowCount() <= 1) {
                            int row = tracksTable.getRowSorter().convertRowIndexToModel(lastSelectedRow);
                            int trackId = (Integer) model.getValueAt(row, 0);
                            Environment.getWorkspaceInstance().getSnippetManager().previewAlbum(trackId);
                        } else {
                            ArrayList<Integer> trackIds = new ArrayList<Integer>(tracksTable.getSelectedRowCount());
                            for (int row : tracksTable.getSelectedRows()) {
                                int rowModel = tracksTable.getRowSorter().convertRowIndexToModel(row);
                                int id = (Integer) model.getValueAt(rowModel, 0);
                                trackIds.add(id);
                            }
                            Environment.getWorkspaceInstance().getSnippetManager().previewAlbums(trackIds);
                        }

                    } else if (item.getText().contains("Artist")) {
                        //preview of an artist
                        if (tracksTable.getSelectedRowCount() <= 1) {
                            int row = tracksTable.getRowSorter().convertRowIndexToModel(lastSelectedRow);
                            int trackId = (Integer) model.getValueAt(row, 0);
                            Environment.getWorkspaceInstance().getSnippetManager().previewArtist(trackId);
                        } else {
                            ArrayList<Integer> trackIds = new ArrayList<Integer>(tracksTable.getSelectedRowCount());
                            for (int row : tracksTable.getSelectedRows()) {
                                int rowModel = tracksTable.getRowSorter().convertRowIndexToModel(row);
                                int id = (Integer) model.getValueAt(rowModel, 0);
                                trackIds.add(id);
                            }
                            Environment.getWorkspaceInstance().getSnippetManager().previewArtists(trackIds);
                        }

                    }

                }
            }
        });*/

        contextMenu.add(previewElementMenu);
        contextMenu.add(findSimilarElementMenu);
        contextMenu.add(findNonSimilarElementMenu);
        contextMenu.add(addElementToPlaylistMenu);
        contextMenu.addSeparator();
        contextMenu.add(closeMenu);

        return contextMenu;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        maybeShowPopup(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        maybeShowPopup(e);
    }
}