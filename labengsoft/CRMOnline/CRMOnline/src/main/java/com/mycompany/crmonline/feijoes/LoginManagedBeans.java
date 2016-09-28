package com.mycompany.crmonline.feijoes;

  import javax.faces.application.FacesMessage;
  import javax.faces.bean.ManagedBean;
  import javax.faces.bean.ViewScoped;
  import javax.faces.context.FacesContext;
   
  import com.mycompany.crmonline.dao.UsuarioDAO;
  import com.mycompany.crmonline.Usuario;
   
  @ManagedBean(name = "LoginMB")
  @ViewScoped
  public class LoginManagedBeans {
   
        private UsuarioDAO usuarioDAO = new UsuarioDAO();
        private Usuario usuario = new Usuario();
        
        public String envia() {
              
              usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
              if (usuario == null) {
                    usuario = new Usuario();
                    FacesContext.getCurrentInstance().addMessage(
                               null,
                               new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                           "Erro no Login!"));
                    return null;
              } else {
                    return "/main";
              }
              
              
        }
   
        public Usuario getUsuario() {
              return usuario;
        }
   
        public void setUsuario(Usuario usuario) {
              this.usuario = usuario;
        }
  }
