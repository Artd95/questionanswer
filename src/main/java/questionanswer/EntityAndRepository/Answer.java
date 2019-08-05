package questionanswer.EntityAndRepository;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idA;
    @Column
    public String textA;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iduser")
        private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idquestion")
    private Question question;

    public Integer getIdA() { return idA; }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public String getTextA() {
        return textA;
    }

    public void setTextA(String textA) {
        this.textA = textA;
    }

    public  Question getQuestion(){return question;}

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getIdquestion() {
        return question.getId();}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();}

}
