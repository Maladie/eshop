<div class="row ">
    <div class="col-md-3">
        <div class="form-group sr-only">
            <input type="hidden" name="id" value="${id}">
        </div>
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" name="title" id="title" placeholder="Enter product title"
                   value="${product.title}" required>
        </div>
        <div class="form-group">
            <label for="authorName">Author's Name:</label>
            <input type="text" class="form-control" name="authorName" id="authorName" placeholder="Enter brand author's name" required>
        </div>
        <div class="form-group">
            <label for="authorSurname">Author's Surname:</label>
            <input type="text" class="form-control" name="authorSurname" id="authorSurname" placeholder="Enter brand author's surname" required>
        </div>
    </div>
    <div class="col-md-3">
        <div class="form-group">
            <label for="category">Category:</label>
            <select class="form-control" id="category" name="category">
                <option ${product.parametersMap["category"] == 'BIOGRAPHIES_MEMOIRS'? selected:''}>BIOGRAPHIES_MEMOIRS</option>
                <option ${product.parametersMap["category"] == 'HISTORY'? selected:''}>History</option>
                <option ${product.parametersMap["category"] == 'LITERATURE_FICTION'? selected:''}>Literature fiction</option>
                <option ${product.parametersMap["category"] == 'MYSTERY'? selected:''}>Mystery</option>
                <option ${product.parametersMap["category"] == 'THRILLER_SUSPENSE'? selected:''}>Thriller, suspense</option>
                <option ${product.parametersMap["category"] == 'ROMANCE'? selected:''}>Romance</option>
                <option ${product.parametersMap["category"] == 'SCIENCE_FICTION_FANTASY'? selected:''}>Science fiction, fantasy</option>
                <option ${product.parametersMap["category"] == 'OTHER'? selected:''}>Other</option>
            </select>
        </div>
        <div class="form-group">
            <label for="isbn13">ISBN13:</label>
            <input type="text" class="form-control" name="isbn13" id="isbn13" placeholder="Enter isbn13" required>
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