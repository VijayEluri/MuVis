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

/**
 * This class holds the messages for the application
 * @author Ricardo
 */
public class Messages {

    /**
     * #########################
     * MuVis Generic Messages
     * #########################
     */
    public static String MUVIS_QUOTE = "MuVis - Because Music Visualization matters";
    public static String MUVIS_ABOUT_LABEL = "About MuVis";

    /**
     * #########################
     * MuVis Interface Menus
     * #########################
     */

    /**
     * #########################
     * System Tray Messages
     * #########################
     */
    
    public static String SYSTEM_TRAY_NOT_SUPPORTED = "SystemTray is not supported";
    public static String SYSTEM_TRAY_ABOUT_MENU_ITEM = "About";
    public static String SYSTEM_TRAY_HIDE_MENU_ITEM = "Hide";
    public static String SYSTEM_TRAY_SHOW_MENU_ITEM = "Show";
    public static String SYSTEM_TRAY_PLAY_MENU_ITEM = "Play";
    public static String SYSTEM_TRAY_PAUSE_MENU_ITEM = "Play";
    public static String SYSTEM_TRAY_STOP_MENU_ITEM = "Stop";
    public static String SYSTEM_TRAY_NEXT_TRACK_MENU_ITEM = "Next track";
    public static String SYSTEM_TRAY_PREV_TRACK_MENU_ITEM = "Prev track";
    public static String SYSTEM_TRAY_EXIT_MENU_ITEM = "Exit";

    /**
     * #########################
     * MuVis JTable Messages
     * #########################
     */

    /**
     * JTable Columns
     */
    public static final String COL_TRACK_NUMBER_LABEL = "Nr.";
    public static final String COL_TRACK_NAME_LABEL = "Track name";
    public static final String COL_ALBUM_NAME_LABE = "Album";
    public static final String COL_ARTIST_NAME_LABEL = "Artist";
    public static final String COL_TRACK_DURATION_LABEL = "Duration";
    public static final String COL_TRACK_YEAR_LABEL = "Year";
    public static final String COL_TRACK_GENRE_LABEL = "Genre";
    public static final String COL_TRACK_BEAT_LABEL = "Beat";
    public static final String COL_TRACK_MOOD_LABEL = "Mood";

    /**
     * Preview Operation
     */
    public static final String PREVIEW_TRACK_LABEL = "Preview Track";
    public static final String PREVIEW_ALBUM_LABEL = "Preview Album";
    public static final String PREVIEW_ARTIST_LABEL = "Preview Artist";

    public static final String PREVIEW_SEVERAL_TRACKS_LABEL = "Preview Tracks";
    public static final String PREVIEW_SEVERAL_ALBUMS_LABEL = "Preview Albums";
    public static final String PREVIEW_SEVERAL_ARTISTS_LABEL = "Preview Artists";

    /**
     * (Non) Similarity Operation
     */
    public static final String FIND_SIMILAR_TRACKS_LABEL = "Find Similar Tracks";
    public static final String FIND_SIMILAR_ALBUMS_LABEL = "Find Similar Albums";
    public static final String FIND_SIMILAR_ARTISTS_LABEL = "Find Similar Artists";

    public static final String FIND_NON_SIMILAR_TRACKS_LABEL = "Find Non Similar Tracks";
    public static final String FIND_NON_SIMILAR_ALBUMS_LABEL = "Find Non Similar Albums";
    public static final String FIND_NON_SIMILAR_ARTISTS_LABEL = "Find Non Similar Artists";

    /**
     * Add to Playlist Operation
     */
    public static final String ADD_TRACK_PLAYLIST_LABEL = "Add Track to Playlist";
    public static final String ADD_ALBUM_PLAYLIST_LABEL = "Add Album to Playlist";
    public static final String ADD_ARTIST_PLAYLIST_LABEL = "Add Artist to Playlist";

    public static final String ADD_SEVERAL_TRACKS_PLAYLIST_LABEL = "Add Tracks to Playlist";
    public static final String ADD_SEVERAL_ALBUMS_PLAYLIST_LABEL = "Add Albums to Playlist";
    public static final String ADD_SEVERAL_ARTISTS_PLAYLIST_LABEL = "Add Artists to Playlist";

    /**
     * Close Operation
     */

    public static final String CLOSE_LABEL = "Close";
    public static final String RESUME_LABEL = "Resume";
    public static final String PAUSE_LABEL = "Pause";
    public static final String PLAY_LABEL = "Play";
    public static final String CONFIRMATION_LABEL = "Confirmation";

    public static final String TRACK_NAME_LABEL = "Track";
    public static final String ALBUM_NAME_LABEL = "Album";
    public static final String ARTIST_NAME_LABEL = "Artist";

    /**
     * Similarity View
     */
    public static final String NUMBER_SIMILAR_TRACKS_LABEL = "Number of similar tracks";
    public static final String NUMBER_SIMILAR_ALBUMS_LABEL = "Number of similar albums";
    public static final String NUMBER_SIMILAR_ARTISTS_LABEL = "Number of similar tracks";

    /**
     * Load Library - Reload Library
     */
    public static final String LOAD_LIBRARY_FRAME_LABEL = "Loading Library";
    public static final String LOAD_LIBRARY_INITIALIZE_STAGES = "Initializing stages...";
    public static final String LOAD_LIBRARY_TAGS_EXTRACTION = "Stage 1 of 3 - Tags extraction";
    public static final String LOAD_LIBRARY_CONTENT_TRACKS_EXTRACTION = "Stage 2 of 3 -  Content processing";
    public static final String LOAD_LIBRARY_FULL_CONTENT_EXTRACTION = "Stage 3 of 3 - Finishing library processing";
    public static final String LOAD_LIBRARY_FINISH_LABEL = "Library Processing Finished! Please restart MuVis!";
    public static final String LOAD_LIBRARY_CONFIRMATION_SCREEN = "Do you really wish to stop library loading?\nMuVis will load your library later.";


    /**
     * Generic strings
     */
    public static final String EMPTY_STRING = "";
    public static final String JFILE_CHOOSER_SELECT_LIBRARY = "Select a library folder";

}
