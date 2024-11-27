/*
 Ileigh Aube, Alexander Mayo, Espen Wold
 CSI 340 Final Project: Electronic Secretary
 */

package component;

public abstract class SecretaryCompositeComponent extends SecretaryComponent {
    private List<SecretaryComponent> components = new ArrayList<SecretaryComponent>();

    @Override
    public void addElement(SecretaryComponent component){
        component.add(component);
    }

    public abstract String compose();
}
