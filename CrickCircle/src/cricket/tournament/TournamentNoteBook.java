package cricket.tournament;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import cricket.entities.Tournament;
import cricket.main.ui.CrickCircle;
import cricket.main.ui.FullScoreCard;
import cricket.main.ui.MatchSummary;

public class TournamentNoteBook extends JDialog {

	
	PointTable groupATable,groupBTable;
	PlayOFF playOffPanel;
	FullScoreCard fullScoreCardPanel;
	MatchSummary matchSummaryPanel;
	private JButton matchSummary;
	private JButton fullScoreCard;
	private JButton groupAButton;
	private JButton groupBButton;
	private JButton playOff;
	
	public TournamentNoteBook(CrickCircle frame, boolean modal,Tournament tournament) {
		
		// TODO NoteBook
		super(frame,modal);
		setLayout(null);
		
		fullScoreCardPanel=new FullScoreCard(frame.match.getUserInnings());
		fullScoreCardPanel.setBounds(0,0,900,500);
		add(fullScoreCardPanel);
		fullScoreCardPanel.setVisible(true);
		
		groupATable=new PointTable(tournament.getUserNation(),tournament.getGroupA(),"GroupA");
		groupATable.setBounds(0,0,900,500);
		add(groupATable);
		groupATable.setVisible(false);
		
		groupBTable=new PointTable(tournament.getUserNation(),tournament.getGroupB(),"GroupB");
		groupBTable.setBounds(0,0,900,500);
		add(groupBTable);
		groupBTable.setVisible(false);
		
		playOffPanel=new PlayOFF(tournament);
		playOffPanel.setBounds(0,0,900,500);
		add(playOffPanel);
		playOffPanel.setVisible(false);
		
		matchSummaryPanel=new MatchSummary(frame.match.getUserInnings(),frame.match.getOpponentInnings());
		matchSummaryPanel.setBounds(0,0,900,500);
		add(matchSummaryPanel);
		matchSummaryPanel.setVisible(false);
		
		
		fullScoreCard = new JButton("FullScoreCard");
		fullScoreCard.setBounds(0,500,160,30);
		add(fullScoreCard);
		
		matchSummary=new JButton("MatchSummary");
		matchSummary.setBounds(170,500,160,30);
		add(matchSummary);
		
		groupAButton=new JButton("GroupA");
		groupAButton.setBounds(340,500,160,30);
		add(groupAButton);
		
		
		groupBButton=new JButton("GroupB");
		groupBButton.setBounds(510,500,160,30);
		add(groupBButton);
		
		playOff=new JButton("PlayOff");
		playOff.setBounds(680,500,160,30);
		add(playOff);
		
		groupBButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupATable.setVisible(false);
				groupBTable.setVisible(true);
				playOffPanel.setVisible(false);
				fullScoreCardPanel.setVisible(false);
				matchSummaryPanel.setVisible(false);
			}
			
		});

		
		groupAButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupATable.setVisible(true);
				groupBTable.setVisible(false);
				playOffPanel.setVisible(false);

				fullScoreCardPanel.setVisible(false);
				matchSummaryPanel.setVisible(false);
			}
			
		});
		playOff.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				groupATable.setVisible(false);
				groupBTable.setVisible(false);
				playOffPanel.setVisible(true);

				fullScoreCardPanel.setVisible(false);
				matchSummaryPanel.setVisible(false);
			}
			
		});
		
		fullScoreCard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupATable.setVisible(false);
				groupBTable.setVisible(false);
				playOffPanel.setVisible(false);

				fullScoreCardPanel.setVisible(true);
				matchSummaryPanel.setVisible(false);
			}
			
		});
		
		matchSummary.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupATable.setVisible(false);
				groupBTable.setVisible(false);
				playOffPanel.setVisible(false);
				fullScoreCardPanel.setVisible(false);
				matchSummaryPanel.setVisible(true);
			}
		});
	}
}