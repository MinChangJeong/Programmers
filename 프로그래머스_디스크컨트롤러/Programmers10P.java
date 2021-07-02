package ���α׷��ӽ�_��ũ��Ʈ�ѷ�;

import java.util.*;

public class Programmers10P {
	public int solution(int[][] jobs) {

		int answer = 0;
		int end = 0; // ����ǰ� ������ �ð�
		int jobsIdx = 0; // jobs �迭�� �ε���
		int count = 0; // ����� ��û ����

		// ���� �迭 �������� ���� (��û�ð� ��������)
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		// ó�� �ð� ������������ ���ĵǴ� �켱���� ť(Heap)
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		// ��û�� ��� ����� ������ �ݺ�
		while (count < jobs.length) {

			// �ϳ��� �۾��� �Ϸ�Ǵ� ����(end)���� ���� ��� ��û�� ť�� ����
			while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
				pq.add(jobs[jobsIdx++]);
			}

			// ť�� ����ִٸ� �۾� �Ϸ�(end) ���Ŀ� �ٽ� ��û�� ���´ٴ� �ǹ�
			// (end�� ��û�� ���� ó������ ������)
			if (pq.isEmpty()) {
				end = jobs[jobsIdx][0];

			// �۾��� ������ ��(end ����) ���� ��û �� ���� ����ð��� ª�� ��û���� ����
			} else {
				int[] temp = pq.poll();
				answer += temp[1] + end - temp[0];
				end += temp[1];
				count++;
			}
		}

		return (int) Math.floor(answer / jobs.length);
	}
	
}
