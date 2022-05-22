export interface Drink {
    id: number;
    name: string;
    alcoholic: boolean;
    caffeine: boolean;
    hot: boolean;
    texture: string;
    taste?: any;
    ingredients?: string[];
}