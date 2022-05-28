import { Answer } from "./Answer";
import { Question } from "./Question";

export interface AnsweredQuestion {
    id : number;
    processed : boolean;
    question : Question;
    answer : Answer;
}