package gui;

import datacollection.*;
import sentimenttracker.ScoreRating;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainGUI implements Runnable {

    public JFrame createFrame() {
        JFrame frame = new JFrame("Stock Analysis");
        frame.setBounds(100, 100, 750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }

    public JLabel createLabel1(JFrame frame) {
        JLabel tickerLabel = new JLabel("Ticker:");
        tickerLabel.setBounds(245, 31, 100, 23);
        frame.getContentPane().add(tickerLabel);
        return tickerLabel;
    }

    public JLabel createLabel2(JFrame frame) throws IOException {
        JLabel currentPriceLabel = new JLabel("Current Price: ");
        currentPriceLabel.setBounds(125, 150, 250, 23);
        frame.getContentPane().add(currentPriceLabel);
        return currentPriceLabel;
    }

    public JLabel createLabel3(JFrame frame) throws IOException {
        JLabel highPriceLabel = new JLabel("One Year High Price: " );
        highPriceLabel.setBounds(125, 200, 250, 23);
        frame.getContentPane().add(highPriceLabel);
        return highPriceLabel;
    }

    public JLabel createLabel4(JFrame frame) throws IOException {
        JLabel lowPriceLabel = new JLabel("One Year Low Price: ");
        lowPriceLabel.setBounds(125, 250, 250, 23);
        frame.getContentPane().add(lowPriceLabel);
        return lowPriceLabel;
    }

    public JLabel createLabel5(JFrame frame) {
        JLabel marketCapLabel = new JLabel("Market Cap: " + FetchMarketCap.fetchMarketCap());
        marketCapLabel.setBounds(475, 150, 250, 23);
        frame.getContentPane().add(marketCapLabel);
        return marketCapLabel;
    }

    public JLabel createLabel6(JFrame frame) throws IOException {
        JLabel oneYearPriceRangeLabel = new JLabel("One Year Price Range: ");
        oneYearPriceRangeLabel.setBounds(125, 300, 250, 23);
        frame.getContentPane().add(oneYearPriceRangeLabel);
        return oneYearPriceRangeLabel;
    }

    public JLabel createLabel7(JFrame frame) {
        JLabel peRatioLabel = new JLabel("PE Ratio: " + FetchPERatio.fetchPERatio());
        peRatioLabel.setBounds(475, 200, 250, 23);
        frame.getContentPane().add(peRatioLabel);
        return peRatioLabel;
    }

    public JLabel createLabel8(JFrame frame) {
        JLabel floatLabel = new JLabel("Float: " + FetchFloat.fetchFloat());
        floatLabel.setBounds(125, 350, 250, 23);
        frame.getContentPane().add(floatLabel);
        return floatLabel;
    }

    public JLabel createLabel9(JFrame frame) throws IOException {
        JLabel cashFlowLabel = new JLabel("Cash Flow Per Share: " + FetchCashFlow.fetchCashFlow());
        cashFlowLabel.setBounds(475, 250, 250, 23);
        frame.getContentPane().add(cashFlowLabel);
        return cashFlowLabel;
    }

    public JLabel createLabel10(JFrame frame) {
        JLabel bookValueLabel = new JLabel("Book Value: " + FetchBookValue.fetchBookValue());
        bookValueLabel.setBounds(475, 300, 250, 23);
        frame.getContentPane().add(bookValueLabel);
        return bookValueLabel;
    }

    public JLabel createLabel11(JFrame frame) throws IOException {
        JLabel scoreLabel = new JLabel("Score Rating: ");
        scoreLabel.setBounds(475, 350, 250, 23);
        frame.getContentPane().add(scoreLabel);
        return scoreLabel;
    }

    public JTextField createInput(JFrame frame) {
        JTextField tickerInput = new JTextField();
        tickerInput.setBounds(290, 33, 95, 20);
        tickerInput.setColumns(10);
        frame.getContentPane().add(tickerInput);
        return tickerInput;
    }

    public JButton createSearchButton(JFrame frame) {
        JButton tickerSearch = new JButton("Search");
        tickerSearch.setBounds(390, 31, 89, 23);
        frame.getContentPane().add(tickerSearch);
        return tickerSearch;

    }

    public void addEventListeners(JTextField input, JButton search) {
        search.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String textInput = input.getText();
                System.out.println(textInput);
                input.setText("");
            }

        });

    }
    public void run() {
        try {
            JFrame frame = createFrame();
            JButton button1 = createSearchButton(frame);
            JLabel label1 = createLabel1(frame);
            JLabel label2 = createLabel2(frame);
            JLabel label3 = createLabel3(frame);
            JLabel label4 = createLabel4(frame);
            JLabel label5 = createLabel5(frame);
            JLabel label6 = createLabel6(frame);
            JLabel label7 = createLabel7(frame);
            JLabel label8 = createLabel8(frame);
            JLabel label9 = createLabel9(frame);
            JLabel label10 = createLabel10(frame);
            JLabel label11 = createLabel11(frame);
            JTextField input = createInput(frame);
            addEventListeners(input,button1);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(new MainGUI());
    }

    public MainGUI() {}
}
