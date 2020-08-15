package edu.bit.board.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
  //����¡ ó���� ���ؼ� ������ ��ȣ�� ���������� ��� �����͸� �����ٰ����� �����Ǿ�߸� ��.
  private int pageNum; //������ ��ȣ
  private int amount; //���������� ��� �����͸� �����ٰ��ΰ�?

  public Criteria() {
    this(1, 10); //�⺻�� 1������ 10���� ����
  }

  public Criteria(int pageNum, int amount) {
    this.pageNum = pageNum;
    this.amount = amount;
  }

}
