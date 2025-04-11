package org.cache2k.config;
public class CacheTypeCapture<T> implements CacheType<T> {
  private final CacheType<T> descriptor =
    (CacheType<T>) CacheType.of(
      ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
  protected CacheTypeCapture() { }
  @Override
  public  CacheType<?> getComponentType() {
    return descriptor.getComponentType();
  }
  @Override
  public  Class<T> getType() {
    return descriptor.getType();
  }
  @Override
  public  CacheType<?>[] getTypeArguments() {
    return descriptor.getTypeArguments();
  }
  @Override
  public String getTypeName() {
    return descriptor.getTypeName();
  }
  @Override
  public boolean hasTypeArguments() {
    return descriptor.hasTypeArguments();
  }
  @Override
  public boolean isArray() {
    return descriptor.isArray();
  }
  @Override
  public boolean equals(Object o) {
    return descriptor.equals(o);
  }
  @Override
  public int hashCode() {
    return descriptor.hashCode();
  }
  @Override
  public String toString() {
    return descriptor.toString();
  }
  private abstract static class BaseType<T> implements CacheType<T> {
    @Override
    public  CacheType<?> getComponentType() {
      return null;
    }
    @Override
     public Class<T> getType() {
      return null;
    }
    @Override
    public  CacheType<?>[] getTypeArguments() {
      return null;
    }
    @Override
    public boolean hasTypeArguments() {
      return false;
    }
    @Override
    public boolean isArray() {
      return false;
    }
    @Override
    public final String toString() {
      return DESCRIPTOR_TO_STRING_PREFIX + getTypeName();
    }
  }
  public static class OfClass<T> extends BaseType<T> {
    private final Class<T> type;
    public OfClass(Class<T> type) {
      if (type.isArray()) {
        throw new IllegalArgumentException("array is not a regular class");
      }
      this.type = type;
    }
    @Override
    public Class<T> getType() {
      return type;
    }
    static String shortenName(String s) {
      final String langPrefix = "java.lang.";
      if (s.startsWith(langPrefix)) {
        return s.substring(langPrefix.length());
      }
      return s;
    }
    @Override
    public String getTypeName() {
      return shortenName(type.getCanonicalName());
    }
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      OfClass<?> classType = (OfClass<?>) o;
      return type.equals(classType.type);
    }
    @Override
    public int hashCode() {
      return type.hashCode();
    }
  }
  public static class OfArray extends BaseType<Void> {
    private final CacheType<?> componentType;
    public OfArray(CacheType<?> componentType) {
      this.componentType = componentType;
    }
    @Override
    public boolean isArray() {
      return true;
    }
    @Override
    public CacheType<?> getComponentType() {
      return componentType;
    }
    private static int countDimensions(CacheType<?> td) {
      int cnt = 0;
      while (td.isArray()) {
        td = td.getComponentType();
        cnt++;
      }
      return cnt;
    }
    static Class<?> finalPrimitiveType(CacheType<?> td) {
      while (td.isArray()) {
        td = td.getComponentType();
      }
      return td.getType();
    }
    @Override
    public String getTypeName() {
      StringBuilder sb = new StringBuilder();
      int dimensions = countDimensions(this);
      if (dimensions > 1) {
        sb.append(finalPrimitiveType(this));
      } else {
        sb.append(getComponentType().getTypeName());
      }
      for (int i = 0; i < dimensions; i++) {
        sb.append("[]");
      }
      return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
      if (this == o) { return true; }
      if (o == null || getClass() != o.getClass()) { return false; }
      OfArray arrayType = (OfArray) o;
      return componentType.equals(arrayType.componentType);
    }
    @Override
    public int hashCode() {
      return componentType.hashCode();
    }
  }
  public static class OfGeneric<T> extends BaseType<T> {
    private final CacheType<?>[] typeArguments;
    private final Class<T> type;
    public OfGeneric(Class<T> type, CacheType<?>[] typeArguments) {
      this.typeArguments = typeArguments;
      this.type = type;
    }
    @Override
    public Class<T> getType() {
      return type;
    }
    @Override
    public boolean hasTypeArguments() {
      return true;
    }
    @Override
    public CacheType<?>[] getTypeArguments() {
      return typeArguments;
    }
    @Override
    public String getTypeName() {
      return
        OfClass.shortenName(type.getCanonicalName()) + "<" + arrayToString(typeArguments) + '>';
    }
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      OfGeneric<?> that = (OfGeneric<?>) o;
      return Arrays.equals(typeArguments, that.typeArguments) && type.equals(that.type);
    }
    @Override
    public int hashCode() {
      int result = Arrays.hashCode(typeArguments);
      result = 31 * result + type.hashCode();
      return result;
    }
  }
  static String arrayToString(CacheType<?>[] a) {
    if (a.length < 1) {
      throw new IllegalArgumentException();
    }
    StringBuilder sb = new StringBuilder();
    int l = a.length - 1;
    for (int i = 0; ; i++) {
      sb.append(a[i].getTypeName());
      if (i == l)
        return sb.toString();
      sb.append(',');
    }
  }
}
