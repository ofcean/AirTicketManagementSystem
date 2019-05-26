package spg.UI;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AppModel
{
    private StringProperty text;

    private AppModel()
    {
        this.text = new SimpleStringProperty();
    }

    private StringProperty textProperty() {
        return text;
    }

    public final String getText() {
        return textProperty().get();
    }

    public final void setText(String text) {
        textProperty().set(text);
    }
}