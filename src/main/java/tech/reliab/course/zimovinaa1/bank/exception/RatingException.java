package tech.reliab.course.zimovinaa1.bank.exception;

public class RatingException extends Exception{
    public RatingException()
    {
        super("Ваш кредитный рейтинг не соответсвтует банковским требованиям!");
    }
}
