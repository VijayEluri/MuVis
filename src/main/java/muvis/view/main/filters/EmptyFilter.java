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

package muvis.view.main.filters;

import java.util.List;

import muvis.database.MusicLibraryDatabaseManager;
import muvis.util.Observable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Empty filter for composition purposes
 * @author Ricardo
 */
public class EmptyFilter extends TreemapFilter {
    @Autowired
    private MusicLibraryDatabaseManager dbManager;
    @Override
    public int getCountFilteredTracks(String artistName) {
        return dbManager.getArtistTracks(artistName).size();
    }

    @Override
    public int getCountFilteredAlbuns(String artistName) {
        return dbManager.getArtistAlbums(artistName).size();
    }

    @Override
    public List getFilteredTracks(String artistName) {
        return dbManager.getArtistTracks(artistName);
    }

    @Override
    public List getFilteredAlbuns(String artistName) {
        return dbManager.getArtistAlbums(artistName);
    }

    @Override
    public void reset() {
        //no operation is necessary
    }

    @Override
    protected String getQuery(String artistName) {
        query = "1=1";
        return query;
    }

    @Override
    public void update(Observable obs, Object arg) {
        //nothing to do
    }

}
