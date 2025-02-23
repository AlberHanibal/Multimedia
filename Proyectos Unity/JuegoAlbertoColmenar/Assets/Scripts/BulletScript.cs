using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BulletScript : MonoBehaviour
{
    public float Speed;
    private Vector2 Direction;
    private Rigidbody2D Rigidbody2D;
    public AudioClip Sound;


    // Start is called before the first frame update
    void Start()
    {
        Rigidbody2D = GetComponent<Rigidbody2D>();
        Camera.main.GetComponent<AudioSource>().PlayOneShot(Sound);

    }

    // Update is called once per frame
    void Update()
    {
        Rigidbody2D.velocity = Direction * Speed;
    }

    public void setDirection(Vector2 direction)
    {
        Direction = direction;
    }

    public void DestroyBullet()
    {
        Destroy(gameObject);
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        JohnMovement john = collision.GetComponent<JohnMovement>();
        GruntScript grunt = collision.GetComponent<GruntScript>();

        if (john != null)
        {
            john.Hit();
        }
        if (grunt != null)
        {
            grunt.Hit();
        }
        DestroyBullet();
    }
}
