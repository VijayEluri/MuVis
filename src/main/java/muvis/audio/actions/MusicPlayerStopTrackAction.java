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
package muvis.audio.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import muvis.Elements;
import muvis.view.MusicControllerView;
import muvis.view.ViewManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ricardo
 */
public class MusicPlayerStopTrackAction implements ActionListener {

    @Autowired
    private ViewManager viewManager;

    @Override
    public void actionPerformed(ActionEvent e) {
        MusicControllerView controller =
                (MusicControllerView) viewManager.getView(Elements.MUSIC_PLAYER_VIEW);
        try {
            controller.stopPlayer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
