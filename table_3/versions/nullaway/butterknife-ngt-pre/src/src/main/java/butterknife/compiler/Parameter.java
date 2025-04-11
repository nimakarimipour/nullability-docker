package butterknife.compiler;

import javax.annotation.Nullable;

import com.squareup.javapoet.TypeName;

/** Represents a parameter type and its position in the listener method. */
final class Parameter {
  static final Parameter[] NONE = new Parameter[0];

  private final int listenerPosition;
  @Nullable private final TypeName type;

  Parameter(int listenerPosition, TypeName type) {
    this.listenerPosition = listenerPosition;
    this.type = type;
  }

  int getListenerPosition() {
    return listenerPosition;
  }

  TypeName getType() {
    return type;
  }

  public boolean requiresCast(String toType) {
    return !type.toString().equals(toType);
  }
}
