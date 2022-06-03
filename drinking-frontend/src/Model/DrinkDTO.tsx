import { Drink } from "./Drink";

export interface DrinkDTO {
    id: number;
    name: string;
    restaurant: string;
    city: string;
    drink: Drink;
}