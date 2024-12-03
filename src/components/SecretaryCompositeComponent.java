/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package components;

import java.util.List;
import java.util.ArrayList;

public abstract class SecretaryCompositeComponent extends SecretaryComponent {
    private List<SecretaryComponent> components = new ArrayList<SecretaryComponent>();

    @Override
    public void addElement(SecretaryComponent component){
        components.add(component);
    }

    public abstract String compose();
}
