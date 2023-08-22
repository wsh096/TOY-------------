import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class boolean배열_Set벤치마크 {
    // 이전에 저장한 경로를 저장하는 정적 변수
    private static String previousPath = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("로또 boolean 배열 Set 활용 성능 비교");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("횟수(0이상) 너무 큰 수는 하루 종일 걸릴 수 있습니다.");
        userLabel.setBounds(10, 10, 300, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(10, 30, 160, 25);
        panel.add(userText);

        JButton runButton = new JButton("실행");
        runButton.setBounds(190, 30, 80, 25);
        panel.add(runButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 120, 360, 100);
        panel.add(resultArea);

        // 실행 로직을 별도의 메서드로 분리
        ActionListener runAction = e -> {
            long startTime = System.currentTimeMillis();
            int iterator = Integer.parseInt(userText.getText());
            long booleanTotal = 0;
            long setTotal = 0;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < iterator; i++) {
                booleanTotal += boolean배열로또();
                setTotal += set활용로또();
            }
            long endTime = System.currentTimeMillis();
            String result = sb.append(iterator).append(" 실행 횟수에 대한 결과입니다.\n")
                .append("boolean배열을 활용한 결과값의 평균은 ").append(booleanTotal).append("ms 입니다.\n")
                .append("Set을 활용한 결과값의 평균은 ").append(setTotal).append("ms 입니다.\n")
                .append("전체 프로그램의 수행 시간은 ").append(endTime - startTime).append("ms 입니다.\n").toString();
            resultArea.setText(result);

            // 파일 저장 대화 상자
            JFileChooser fileChooser = new JFileChooser();
            if (!previousPath.isEmpty()) {
                fileChooser.setCurrentDirectory(new File(previousPath));
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String defaultFileName = "로또 성능 비교 결과_" + sdf.format(new Date()) + ".txt";
            fileChooser.setSelectedFile(new File(defaultFileName));
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                previousPath = fileToSave.getParent();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                    writer.write(result);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        };

        // 버튼에 액션 리스너 추가
        runButton.addActionListener(runAction);

        // 텍스트 필드에 액션 리스너 추가 (엔터 키를 눌렀을 때 동작)
        userText.addActionListener(runAction);
    }

        private static long boolean배열로또(){
        long startTime = System.currentTimeMillis();
        //StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
                int cnt = 0;
                boolean [] Lotto = new boolean[46];
                while(cnt < 6){
                    int pickNum = (int)(Math.random() * 45) + 1;
                    if(Lotto[pickNum]) continue;
                    cnt++;
                    //sb.append(pickNum).append(" ");
                    Lotto[pickNum] = true;
                }
                //sb.append("\n");
            }
            //System.out.println(sb);
            long endTime = System.currentTimeMillis();
             return endTime-startTime;
        }
    
    private static long set활용로또(){
        long startTime = System.currentTimeMillis();
        
        //StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            Set<Integer> set = new HashSet<>();
            int randNum = -1;
            for(int j = 0; j < 6; j++){
                do{
                    randNum = (int)(Math.random()*45 + 1);
                }while(set.contains(randNum));
                set.add(randNum);
                //sb.append(randNum).append(" ");
            }
            //sb.append("\n");
        }
        //System.out.println(sb);
    long endTime = System.currentTimeMillis();
        return endTime-startTime;
 
    }

}
