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

package muvis;

import muvis.view.main.MuVisTreemapNode;

/**
 * Main elementos of the MuVis Interface
 * Each module of the visualization component must be registered here.
 * @author Ricardo
 */
public class Elements {

    public static String MUSIC_PLAYER_VIEW = "musicPlayerView";
    public static String PLAYLIST_VIEW = "playlistView";
    public static String FILE_SYSTEM_VIEW = "filesystemView";
    public static String TREEMAP_VIEW = "TreeMapView";
    public static String LIST_VIEW = "ListView";
    public static String ARTIST_INSPECTOR_VIEW = "artistInspector";
    public static String MAIN_VIEW = "mainView";
    public static String MUVIS_APP_VIEW = "muvisAppView";

    public static String ARTISTS_NBTREE = "artistsNBTree";
    public static String ALBUMS_NBTREE = "albumsNBTree";
    public static String TRACKS_NBTREE = "tracksNBTree";

    public static String OTHERS_NODE = "Others";
    public static MuVisTreemapNode othersNode = null;
}
