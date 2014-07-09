package com.tagtraum.perf.gcviewer.view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.tagtraum.perf.gcviewer.ctrl.GCModelLoaderController;
import com.tagtraum.perf.gcviewer.ctrl.action.OpenRecent;
import com.tagtraum.perf.gcviewer.util.LocalisationHelper;
import com.tagtraum.perf.gcviewer.view.model.RecentURLsModel;

/**
 * RecentFilesMenu.
 * <p/>
 * Date: Sep 25, 2005
 * Time: 10:54:45 PM
 *
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 */
public class RecentResourceNamesMenu extends JMenu {
    private RecentURLsModel model;

    public RecentResourceNamesMenu(final GCModelLoaderController controller) {
        super(LocalisationHelper.getString("main_frame_menuitem_recent_files"));
        this.model = new RecentURLsModel();
        this.model.addRecentURLsListener(new RecentURLsListener(){
            public void remove(RecentURLEvent e) {
                RecentResourceNamesMenu.this.remove(e.getPosition());
            }

            public void add(RecentURLEvent e) {
                RecentResourceNamesMenu.this.add(new JMenuItem(new OpenRecent(controller, e.getURLSet().getUrls())), e.getPosition());
            }
        });
        setMnemonic(LocalisationHelper.getString("main_frame_menuitem_mnemonic_recent_files").charAt(0));
        setToolTipText(LocalisationHelper.getString("main_frame_menuitem_hint_recent_files"));
    }

    public RecentURLsModel getRecentURLsModel() {
        return model;
    }

}