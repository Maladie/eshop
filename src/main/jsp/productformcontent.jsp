<div class="row ">
    <div class="col-md-3">
        <div class="form-group sr-only">
            <input type="hidden" name="id" value="${id}">
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Enter product name"
                   value="${product.name}" required>
        </div>
        <div class="form-group">
            <label for="brand">Brand:</label>
            <input type="text" class="form-control" name="brand" id="brand" placeholder="Enter brand name" required>
        </div>
        <div class="form-group">
            <label for="category">Category:</label>
            <select class="form-control" id="category" name="category">
                <option ${product.parametersMap["category"] == 'DISHWASHER'? selected:''}>DISHWASHER</option>
                <option ${product.parametersMap["category"] == 'FREEZER'? selected:''}>FREEZER</option>
                <option ${product.parametersMap["category"] == 'KETTLE'? selected:''}>KETTLE</option>
                <option ${product.parametersMap["category"] == 'MICROWAVE_OVEN'? selected:''}>MICROWAVE_OVEN</option>
                <option ${product.parametersMap["category"] == 'OVEN'? selected:''}>OVEN</option>
                <option ${product.parametersMap["category"] == 'REFRIGERATOR'? selected:''}>REFRIGERATOR</option>
                <option ${product.parametersMap["category"] == 'WASHING_MACHINE'? selected:''}>WASHING_MACHINE</option>
                <option ${product.parametersMap["category"] == 'OTHER'? selected:''}>OTHER</option>
            </select>
        </div>
    </div>
    <div class="col-md-3">

        <div class="form-group">
            <label for="weight">Weight:</label>
            <div class="input-group">
            <input type="number" class="form-control" name="weight" id="weight" placeholder="Weight"
                   value="${product.parametersMap["weightValue"]}" required>
            <select class="form-control" id="weightunit" title="weightunit" name="weightunit">
                <option>GRAMS</option>
                <option>KILOGRAMS</option>
                <option>TONES</option>
            </select>
            </div>
        </div>
        <div class="form-group">
            <label for="eclass">Energy Consumption Class</label>
            <select class="form-control" id="eclass" name="eclass">
                <option>AAA</option>
                <option>AA</option>
                <option>A</option>
                <option>B</option>
                <option>C</option>
                <option>D</option>
            </select>
        </div>
        <div class="form-group">
            <label for="chooseFile">Choose product image:</label>
            <br>
            <label class="custom-file" id="chooseFile">
                <input type="file" name="image" id="file2" class="custom-file-input">
                <span class="custom-file-control"></span>
            </label>
        </div>
    </div>
    <div class="col-md-3">

        <div class="form-group">
            <label for="amount">Amount for Sale:</label>
            <input type="number" class="form-control" name="amount" id="amount" placeholder="Enter Amount"
                   value="${product.productAmount}" required>
        </div>
        <div class="form-group">
            <label for="value">Value:</label>
            <div class="input-group">
                <input type="number" class="form-control" name="value" id="value" placeholder="Value"
                       value="${product.value}" required>
                <select class="form-control selectpicker" title="currency" aria-label="currency" name="currency">
                    <option>PLN</option>
                    <option>EUR</option>
                    <option>USD</option>
                    <option>GBP</option>
                </select>
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" rows="7" name="description"
                      required>${product.description}</textarea>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-outline-success btn-block">Persist product</button>
        </div>
    </div>
</div>