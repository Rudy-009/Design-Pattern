class NutritionFacts {
    private let servingSize: Int
    private let servings: Int
    private let calories: Int
    private let fat: Int
    private let sodium: Int
    private let carbohydrate: Int

    public class Builder {
        // Required parameters
        let servingSize: Int
        let servings: Int
        // Optional parameters - initialized to default vals
        var calories = 0
        var fat = 0
        var sodium = 0
        var carbohydrate = 0

        public init(servingSize: Int, servings: Int) {
            self.servingSize = servingSize;
            self.servings = servings;
        }
        public func calories(val: Int) -> Builder{
            self.calories = val
            return self
        }
        public func fat(val: Int) -> Builder {
            self.fat = val
            return self
        }
        public func sodium(val: Int) -> Builder {
            self.sodium = val
            return self
        }
        public func carbohydrate(val: Int) -> Builder {
            self.carbohydrate = val
            return self
        }
        public func build() -> NutritionFacts {
            return NutritionFacts(builder: self)
        }
    }

    private init(builder: Builder) {
        self.servingSize = builder.servingSize
        self.servings = builder.servings
        self.calories = builder.calories
        self.fat = builder.fat
        self.sodium = builder.sodium
        self.carbohydrate = builder.carbohydrate
    }

    public func description() -> String {
        return """
        NutritionFacts:
          Serving Size: \(servingSize)
          Servings: \(servings)
          Calories: \(calories)
          Fat: \(fat)
          Sodium: \(sodium)
          Carbohydrate: \(carbohydrate)
        """
    }
}

// 사용 예시:
let nutritionFacts = NutritionFacts.Builder(servingSize: 240, servings: 2)
    .calories(val: 100)
    .fat(val: 1)
    .sodium(val: 35)
    .carbohydrate(val: 27)
    .build()

print(nutritionFacts.description())