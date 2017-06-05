package task2;

import task2.annotation.SaveTo;

/**
 * <p>Class container for {@link String}</p>
 */

public class TextContainer {
    @SaveTo("C:\\myFile.txt")
    private String text="Hi";


    /**
     * Constructor without parameters.
     */
    public TextContainer() {
    }

    /**
     * Constructor with one parameter.
     * @param text
     */
    public TextContainer(String text) {
        this.text = text;
    }

    /**
     * Get value of the balance variable.
     * @return value of the text variable.
     */
    public String getText() {
        return text;
    }
}
