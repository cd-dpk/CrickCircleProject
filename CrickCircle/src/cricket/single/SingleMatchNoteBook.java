package cricket.single;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import cricket.entities.Match;
import cricket.main.ui.CrickCircle;
import cricket.main.ui.FullScoreCard;
import cricket.main.ui.MatchSummary;

public class SingleMatchNoteBook  extends JDialog{
	
	FullScoreCard fullScoreCardPanel;
	MatchSummary matchSummaryPanel;
	JButton fullScoreCardButton,matchSummaryButton;
	Match match;
	public SingleMatchNoteBook(CrickCircle frame,boolean modal, Match match) {
		//single  match note book 
		super(frame,modal);
		setLayout(null);
		this.match=match;
		
		fullScoreCardPanel=new FullScoreCard(match.userInnings);
		fullScoreCardPanel.setBounds(0,0,900,500);
		add(fullScoreCardPanel);
		fullScoreCardPanel.setVisible(true);
		
		
		
		matchSummaryPanel=new MatchSummary(match.userInnings,match.opponentInnings);
		matchSummaryPanel.setBounds(0,0,900,500);
		add(matchSummaryPanel);
		matchSummaryPanel.setVisible(false);
		
		
		fullScoreCardButton=new JButton("FullScoreCard");
		fullScoreCardButton.setBounds(0,500,160,30);
		add(fullScoreCardButton);
		fullScoreCardButton.setEnabled(false);
		
		matchSummaryButton=new JButton("MatchSummary");
		matchSummaryButton.setBounds(170,500,160,30);
		add(matchSummaryButton);
		
		fullScoreCardButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				fullScoreCardPanel.setVisible(true);
				fullScoreCardButton.setEnabled(false);
				matchSummaryButton.setEnabled(true);
				matchSummaryPanel.setVisible(false);
			}
		});
		matchSummaryButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fullScoreCardPanel.setVisible(false);
				matchSummaryPanel.setVisible(true);
				fullScoreCardButton.setEnabled(true);
				matchSummaryButton.setEnabled(false);
			}
		});
	}
}